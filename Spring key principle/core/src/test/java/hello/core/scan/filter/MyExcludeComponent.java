package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) //TYPE이라고 하면 class 레벨에 붙는 것
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent { //얘가 붙으면 컴포넌트에서 제외
}
