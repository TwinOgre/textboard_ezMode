package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 시스템 시작 ===");

        List<Article> articleList = new ArrayList<>();
        List<Member> memberList = new ArrayList<>();

        int lastId = 1;
        int memberLastId = 1;
        while (true) {
            System.out.print("명령어) ");
            String command = scanner.nextLine().trim();
            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                System.out.print("제목: ");
                String title = scanner.nextLine();
                System.out.print("내용: ");
                String content = scanner.nextLine();

                Article article = new Article(lastId, title, content);
                articleList.add(article);

                lastId++;
            } else if (command.equals("목록")) {
                System.out.println(articleList.size());
                System.out.println("id / 제목 / 내용");
                System.out.println("-------------------");

                for (Article article : articleList) {
                    System.out.print(article.getId() + ", " + article.getTitle() + ", " + article.getContent() + "\n");
                }
            } else if (command.equals("삭제")) {
                System.out.println("삭제할 ID를 입력하세요.");
                System.out.print("삭제 ID: ");
                int removeId = Integer.parseInt(scanner.nextLine());

                for (int i = 0; i < articleList.size(); i++) {
                    if (articleList.get(i).getId() == removeId) {
                        articleList.remove(articleList.get(i));
                    }
                }

                System.out.println(removeId + "번 게시글이 삭제 되었습니다.");
            } else if (command.equals("수정")) {
                System.out.println("수정할 ID를 입력하세요.");
                System.out.print("수정 ID: ");
                int modifyId = Integer.parseInt(scanner.nextLine());

                for (int i = 0; i < articleList.size(); i++) {
                    if (articleList.get(i).getId() == modifyId) {
                        Article article = articleList.get(i);

                        System.out.println("수정할 제목" + article.getTitle());
                        System.out.println("수정할 내용" + article.getContent());
                        System.out.print("수정 제목 : ");
                        String title = scanner.nextLine();
                        System.out.print("수정 내용 : ");
                        String content = scanner.nextLine();

                        article.setTitle(title);
                        article.setContent(content);
                    }
                }

                System.out.println(modifyId + "번 게시글이 수정 되었습니다.");
            } else if(command.equals("회원가입")){
                System.out.println("== 게시판 회원가입을 환영합니다 ==");
                System.out.println("회원 정보를 입력해주세요");

                System.out.print("아이디) ");
                String memberId = scanner.nextLine();

                System.out.print("비밀번호) ");
                String password = scanner.nextLine();

                System.out.print("비밀번호 확인)");
                String passwordConfirm = scanner.nextLine();
                // 비밀번호 맞는지 확인하는 코드 필요


                //
                System.out.print("닉네임)");
                String nickname = scanner.nextLine();

                Member member = new Member(memberLastId, memberId, password, nickname);
                memberList.add(member);
            } else if(command.equals("로그인")){
                System.out.println("회원 정보를 입력해주세요");
                while (true){
                    System.out.print("아이디) ");
                    String memberId = scanner.nextLine();

                    System.out.print("비밀번호) ");
                    String password = scanner.nextLine();

                    for(Member member : memberList){
                        if(member.getMemberId().equals(memberId) && member.getPassword().equals(password)){
                            System.out.println("환영합니다.");
                            break;
                        }
                    }

                    break;
                }

            }
        }

        scanner.close();
        System.out.println("=== 시스템 종료 ===");
    }
}
