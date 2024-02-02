package com.ohgiraffers.section04.assignment.run;

import com.ohgiraffers.section04.assignment.aggregate.BloodType;
import com.ohgiraffers.section04.assignment.aggregate.Member;
import com.ohgiraffers.section04.assignment.service.MemberService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationGUI extends JFrame {

    private static final MemberService mm = new MemberService();

    public ApplicationGUI() {
        initUI();
    }

    private void initUI() {
        setTitle("회원 관리 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton btn1 = new JButton("모든 회원 정보 보기");
        JButton btn2 = new JButton("회원 찾기");
        JButton btn3 = new JButton("회원 가입");
        JButton btn4 = new JButton("회원 탈퇴");
        JButton btn9 = new JButton("프로그램 종료");

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mm.selectAllMembers();
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mm.selectMember(chooseMemberNo());
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mm.registMember(signUp());
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mm.deleteMember(chooseMemberNo());
            }
        });

        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }
        });

        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn9);

        add(panel);
    }

    private int chooseMemberNo() {
        String input = JOptionPane.showInputDialog("회원 번호를 입력하세요.");
        return Integer.parseInt(input);
    }

    private Member signUp() {
        Member newInfo = null;

        String id = JOptionPane.showInputDialog("아이디를 입력하세요:");
        String pwd = JOptionPane.showInputDialog("패스워드를 입력하세요:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("나이를 입력하세요:"));
        int length = Integer.parseInt(JOptionPane.showInputDialog("입력 할 취미 개수를 입력하세요(숫자로 1이상):"));

        String[] hobbies = new String[length];
        for (int i = 0; i < hobbies.length; i++) {
            hobbies[i] = JOptionPane.showInputDialog((i + 1) + "번째 취미를 입력하세요:");
        }

        newInfo = new Member(id, pwd, age, hobbies);

        String bloodType = JOptionPane.showInputDialog("혈액형을 입력하세요(A, AB, B, O):").toUpperCase();
        BloodType bt = null;

        switch (bloodType) {
            case "A":
                bt = BloodType.A;
                break;
            case "AB":
                bt = BloodType.AB;
                break;
            case "B":
                bt = BloodType.B;
                break;
            case "O":
                bt = BloodType.O;
                break;
        }

        newInfo.setBloodType(bt);
        return newInfo;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ApplicationGUI ex = new ApplicationGUI();
                ex.setVisible(true);
            }
        });
    }
}
