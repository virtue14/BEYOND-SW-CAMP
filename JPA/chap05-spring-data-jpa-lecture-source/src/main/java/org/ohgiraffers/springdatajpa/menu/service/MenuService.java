package org.ohgiraffers.springdatajpa.menu.service;

import org.modelmapper.ModelMapper;
import org.ohgiraffers.springdatajpa.common.Pagination;
import org.ohgiraffers.springdatajpa.menu.controller.MenuController;
import org.ohgiraffers.springdatajpa.menu.dto.CategoryDTO;
import org.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import org.ohgiraffers.springdatajpa.menu.entity.Category;
import org.ohgiraffers.springdatajpa.menu.entity.Menu;
import org.ohgiraffers.springdatajpa.menu.repository.CategoryRepository;
import org.ohgiraffers.springdatajpa.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

import static java.awt.SystemColor.menu;

@Service
public class MenuService {

    /* 설명: Service계층 - 비지니스 로직, 트랜잭션 처리(@Transactional), DTO <-> Entity(modelMapper lib 활용) */

    private final ModelMapper mapper;
    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public MenuService(ModelMapper mapper, MenuRepository menuRepository, CategoryRepository categoryRepository) {
        this.mapper = mapper;
        this.menuRepository = menuRepository;
        this.categoryRepository = categoryRepository;
    }

    /* 설명 1. findById 예제 */
    public MenuDTO findMenuByCode(int menuCode) {
        Menu menu = menuRepository.findById(menuCode).orElseThrow(IllegalArgumentException::new);

        return mapper.map(menu, MenuDTO.class);
    }


    /* 설명 2. findAll(페이징 처리 전) */
    public List<MenuDTO> findMenuList() {
        List<Menu> menulist = menuRepository.findAll(Sort.by("menuCode").descending());

        return menulist.stream().map(menu -> mapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
    }

    /* 설명 3. findAll(페이징 처리 후) */
    public Page<MenuDTO> findMenuList(Pageable pageable) {
        /* 설명
            1. 넘어온 pageable에 담긴 페이지 번호를 인덱스 개념으로 바꿔서 인지 시킴
            2. 한 페이지에 뿌려질 데이터 크기
            3. 정렬 기준
        */
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                                  pageable.getPageSize(),
                                  Sort.by("menuCode").descending());
        Page<Menu> menuList = menuRepository.findAll(pageable);
        return menuList.map(menu -> mapper.map(menu, MenuDTO.class));
    }

    public List<MenuDTO> findMenuPrice(int menuPrice) {
        /* 설명: 전달 받은 가격을 초과하는 메뉴의 목록을 조회하는 메소드 */
        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThan(menuPrice);
        return menuList.stream().map(menu -> mapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
    }

    public List<CategoryDTO> findAllCategory() {
        List<Category> categoryList = categoryRepository.findAllCategory();
        return categoryList.stream().map(category -> mapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public void registMenu(MenuDTO newMenu) {
        menuRepository.save(mapper.map(newMenu, Menu.class));
    }

    @Transactional
    public void modifyMenu(MenuDTO modifyMenu) {
        Menu foundMenu = menuRepository.findById(modifyMenu.getMenuCode()).orElseThrow(IllegalArgumentException::new);
        foundMenu.setMenuCode(modifyMenu.getMenuCode());
    }


    @Transactional
    public void deleteMenu(int menuCode) {
        menuRepository.deleteById(menuCode);
    }
}
