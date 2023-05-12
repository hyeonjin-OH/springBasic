package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    // getInstance를 이용해서만 SingletonService를 호출할 수 있음
    public static SingletonService getInstance(){
        return instance;
    }

    // 외부에서 SingletonService를 호출해서 new 인스턴스 선언 못하게 막음
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
