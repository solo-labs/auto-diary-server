package io.solabs.autodiary.common;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EndPointHelperFactory {

    private final ApplicationContext appContext;

    public EndPointHelper factory() {
        return appContext.getBean("endPointHelper", EndPointHelper.class);
    }
}
