package com.anderfred.cdekTest;

import com.anderfred.cdekTest.entity.Entity;
import com.anderfred.cdekTest.service.TestDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class EntityController {

    Logger logger = LoggerFactory.getLogger(EntityController.class);

    private TestDataService testDataService;

    public EntityController(TestDataService testDataService) {
        this.testDataService = testDataService;
    }


    @GetMapping("/entitys")
    public String getAllParts(Model model) {
        logger.info(" @GetMapping(\"/entitys\")");
        model.addAttribute("entitys", testDataService.findAll());
        return "entitys";
    }

    @GetMapping("/update")
    public String updatePart(@RequestParam("id") String id, Model model) {
        logger.info("@GetMapping(\"/update\")");
        model.addAttribute("entity", testDataService.findById(Integer.parseInt(id)).get());
        return "edit";
    }

    @PostMapping("/updateEntity")
    public String updatePart(@ModelAttribute("id") Integer id, @ModelAttribute("name") String name, Model model) {
        Entity p = testDataService.findById(id).get();
        logger.info("@PostMapping(\"/updateEntity\") :{}", p);
        p.setName(name);
        testDataService.save(p);
        return "redirect:/entitys";
    }

    @GetMapping("/delete")
    public String deletePart(@RequestParam("id") String id) {
        logger.info(" @GetMapping(\"/delete\") id:{}", id);
        testDataService.deleteById(Integer.parseInt(id));
        return "redirect:/entitys";
    }

    @GetMapping("/add")
    public String add(Model model) {
        logger.info("@GetMapping(\"/add\") new Entity");
        model.addAttribute("entity", new Entity());
        return "add";
    }

    @PostMapping("/add")
    public String addPart(@ModelAttribute("entity") Entity entity) {
        logger.info("@PostMapping(\"/add\") :{}",entity);
        testDataService.save(entity);
        return "redirect:/entitys";
    }

    @GetMapping("/populateDB")
    public String populate() {
        logger.info("@GetMapping(\"/populateDB\")");
        try {
            testDataService.populateDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/entitys";
    }
}