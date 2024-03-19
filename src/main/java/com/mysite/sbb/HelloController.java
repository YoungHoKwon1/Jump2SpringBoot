package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 애너테이션은 HelloController 클래스가 컨트롤러의 기능을 수행한다는 의미이다. 이 애너테이션이 있어야 스프링 부트 프레임워크가 컨트롤러로 인식한다.
// 자바의 애너테이션(annotation)이란 자바의 클래스, 메서드, 변수 등에 정보를 부여하여 부가 동작을 할 수 있게 하는 목적으로 사용된다.
public class HelloController {
    @GetMapping("/hello") 
    /* http://localhost:8080/hello URL 요청이 발생하면 hello 메서드가 실행됨을 의미한다. 즉, /hello URL과 hello 메서드를 매핑하는 역할을 한다. 
    이때 URL명과 메서드명이 동일할 필요는 없다. 즉, /hello URL일 때 메서드명을 hello가 아닌 hello2와 같이 써도 상관없다.
     Get 방식의 URL 요청을 위해 @GetMapping을 사용하고, Post 방식의 URL 요청을 위해서는 @PostMapping을 사용한다. */
    @ResponseBody //hello 메서드의 출력 결과가 문자열 그 자체임을 나타낸다.
    public String hello() {
        return "Hello Spring Boot Board";
    }
}

/*Get 방식과 Post 방식은 어떻게 다를까?
Get과 Post는 HTTP 프로토콜을 사용하여 데이터를 서버로 전송하는 주요 방식이다.
 먼저, Get 방식은 데이터를 URL에 노출시켜 요청하며, 주로 서버에서 데이터를 조회하거나 읽기 위한 목적으로 사용한다.
 반면, Post 방식은 데이터를 숨겨서 요청하므로 로그인 정보와 같은 민감한 데이터를 서버에 제출하거나 저장하는 목적으로 사용한다.
 */