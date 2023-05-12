package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Component
@Scope(value = "request" , proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    private String uuid;
    private String requestURL;

    //Alt + Insert 로 getter setter
    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("[" + uuid + "] " + " [" + requestURL + "] "+ message);
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString(); // 유니크 아이디 만들기
        System.out.println("[" + uuid + "] request scope bean create : " + this);

    }

    @PreDestroy
    public void close(){
        System.out.println();
        System.out.println("[" + uuid + "] request scope bean close : " + this);

    }
}
