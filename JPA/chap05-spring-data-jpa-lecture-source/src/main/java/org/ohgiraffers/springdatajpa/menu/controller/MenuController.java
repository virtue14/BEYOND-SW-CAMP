package org.ohgiraffers.springdatajpa.menu.controller;

import lombok.extern.log4j.Log4j2;
import org.ohgiraffers.springdatajpa.common.Pagination;
import org.ohgiraffers.springdatajpa.common.PagingButtonInfo;
import org.ohgiraffers.springdatajpa.menu.dto.CategoryDTO;
import org.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import org.ohgiraffers.springdatajpa.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/menu")
@Log4j2
public class MenuController {
    private final MenuService menuService;

    /* 설명: 로그 생성해 보기 */
//    Logger logger = LoggerFactory.getLogger(MenuController.class);
//    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/{menuCode}")
    public String findMenuByCode(@PathVariable int menuCode, Model model) {
//        logger.info("menuCode: {}", menuCode);
        log.info("menuCode: {}", menuCode);

        MenuDTO menu = menuService.findMenuByCode(menuCode);
        model.addAttribute("menu", menu);

        return "menu/detail";
    }

    /* 설명: 페이징 처리 전 */
//    @GetMapping("/list")
//    public String findMenuList(Model model) {
//        List<MenuDTO> menuList = menuService.findMenuList();
//        model.addAttribute("menuList", menuList);
//        return "menu/list";
//    }

    /* 설명: 페이징 처리 후 */
    @GetMapping("/list")
    public String findMenuList(@PageableDefault Pageable pageable, Model model) {
        log.info("pageable: {}", pageable);

        Page<MenuDTO> menuList = menuService.findMenuList(pageable);

        log.info("조회한 내용 목록: {}", menuList.getContent());
        log.info("총 페이지 수: {}", menuList.getTotalPages());
        log.info("총 메뉴 수: {}", menuList.getTotalElements());
        log.info("해당 페이지에 표시 될 요소 수: {}", menuList.getSize());
        log.info("해당 페이지에 실제 요소 수: {}", menuList.getNumberOfElements());
        log.info("첫 페이지 여부: {}", menuList.isFirst());
        log.info("정렬 방식: {}", menuList.isLast());
        log.info("여러 페이지 중 현재 인덱스: {}", menuList.getNumber());

        /* 설명: 화면에서 버튼을 그리기 위한 필요한 재료 준비(클래스(모듈화) 두 개 추가) */
        PagingButtonInfo paging = Pagination.getPagingButtonInfo(menuList);
        model.addAttribute("paging", paging);
        model.addAttribute("menuList", menuList);

        return "menu/list";
    }

    @GetMapping("/querymethod")
    public void queryMethodPage() {
    }

    @GetMapping("/search")
    public String findMenuPrice(@RequestParam int menuPrice, Model model) {
        List<MenuDTO> menuList = menuService.findMenuPrice(menuPrice);

        model.addAttribute("menuList", menuList);
        model.addAttribute("menuPrice", menuPrice);
        return "/menu/searchResult";
    }

    @GetMapping("/regist")
    public void registPage() {
    }

    /* 설명: /menu/regist,html이 열리자마자 js 코드를 통해 /menu/category 비동기 요청이 오게 된다. */
    @GetMapping(value = "/category", produces = "application/json; charset=UTF-8")

    /* 설명 1. 메소드에 @ResponseBody가 붙은 메소드 반환형은 ViewResolver가 해석하지 않는다. */
    /* 설명 2. @ResponseBody가 붙었을 때 기존과 다른 핸들러 메소드의 차이점
        1. 핸들러 메소드의 반환형이 어떤 것이라도 상관 없다(-> 모두 json 문자열 형태로 요청이 들어온 곳으로 반환된다.)
        2. 한글이 포함된 데이터는 produces속성에 'application/json라는 MIME타입과 'charset=UTF-8' 인코딩 타입을 붙여준다.
    */
    @ResponseBody
    private List<CategoryDTO> findCategoryList() {
        return menuService.findAllCategory();
    }

    /* 설명: Spring Data JPA로 DML 작업하기(Insert, Update, Delete) */
    @PostMapping("/regist")
    public String registMenu(MenuDTO newMenu) {
        menuService.registMenu(newMenu);

        return "redirect:/menu/list";
    }

    @GetMapping("/modify")
    private void modifyPage() {
    }

    @PostMapping("/modify")
    public String modifyMenu(MenuDTO modifyMenu) {
        menuService.modifyMenu(modifyMenu);

        return "redirect:/menu/" + modifyMenu.getMenuCode();
    }

    @GetMapping("/delete")
    private void deletePage() {}
    @PostMapping("/delete")
    public String deleteMenu(@RequestParam int menuCode) {
        menuService.deleteMenu(menuCode);

        return "redirect:/menu/list";
    }
}

