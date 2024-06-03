package cn.dsscm.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cn.dsscm.common.Result;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler  {
    @ExceptionHandler(value = RuntimeException.class)
    public Result<Void> handleRuntimeException(RuntimeException ex) {
        log.error(ex.getMessage());
        return Result.error(500, ex.getMessage());
    }
}
