package io.paulbaker.myadmin.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by paulbaker on 10/13/15.
 */
@Controller
@RequestMapping("/")
public class HomeController {

  private Logger logger = Logger.getLogger(this.getClass());

  @RequestMapping(method = RequestMethod.GET)
  public String getRoot() {
    logger.info("index");
    return "index";
  }

  /**
   * I personally find /index or /index.html or other variants thereof,
   * annoying to look at. This method handles them by automatically
   * redirecting back to the root and removing that variant suffix.
   * <p>
   * Solution was based of this: http://stackoverflow.com/a/18422504/1478636
   *
   * @return
   */
  @RequestMapping(value = "{indexVariant:index(?:\\.html?)?}", method = RequestMethod.GET)
  public String handleIndexVariants(@PathVariable String indexVariant) {
    logger.info("redirect:/");
    return "redirect:/";
  }

}
