package hello.core.lifecycle;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//javax 로 시작하면 자바 표준. 스프링이 아닌 다른 컨테이너에서도 동작함
public class NetworkClient {
    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect = " + url);

    }

    public void call(String message){
        System.out.println("call: "+url+" message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close" + url);
    }

    @PostConstruct
    public void init() { //의존관계 주입 다 끝난 후에 호출함
        System.out.println("NetworkClient.init");
        call("초기화 연결 메시지");
        connect();
    }

    @PreDestroy
    public void close() {
        disconnect();
        System.out.println("NetworkClient.close");
    }
}
