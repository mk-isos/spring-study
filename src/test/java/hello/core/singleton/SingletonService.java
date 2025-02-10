package hello.core.singleton;

public class SingletonService {

    //static 이라서 class 레벨에 올라가 딱 1개 존재하게 됨.
    private static SingletonService instance = new SingletonService();

    //조회할 때
    public static SingletonService getInstance() {
        return instance;
    }

    //private으로 만들기 다른 곳에서 생성 못하도록
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}

/*
*
1. static 영역에 객체 instance를 미리 하나 생성해서 올려둔다.
2. 이 객체 인스턴스가 필요하면 오직 `getInstance()` 메서드를 통해서만 조회할 수 있다. 이 메서드를 호
출하면 항상 같은 인스턴스를 반환한다.
3. 딱 1개의 객체 인스턴스만 존재해야 하므로, 생성자를 private으로 막아서 혹시라도 외부에서 new 키워드
로 객체 인스턴스가 생성되는 것을 막는다.
*
* */
