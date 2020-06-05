package com.hae.common;

import org.slf4j.Logger;

public class LoggerFactory {
  public final static String EXCEPTION = "EXCEPTION ";
  public final static String IGNORED = "IGNORED ";

  /**
   * 返回以调用者的类命名的Logger,是获取Logger对象最简单的方法!
   *
   * @return 调用者的类命名的Logger
   */
  public static Logger getLogger() {
    CommonResult commonResult = new CommonResult();
    return org.slf4j.LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[2]
            .getClassName());
  }
}
