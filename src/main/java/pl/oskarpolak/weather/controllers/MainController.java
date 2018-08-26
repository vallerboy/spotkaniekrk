package pl.oskarpolak.weather.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import pl.oskarpolak.weather.models.WeatherModel;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/")
    public String index(@RequestParam("city") String city,
                        Model model){


        WeatherModel weatherModel = getRestTemplate().getForObject("http://api.openweathermap.org/data/2.5/weather?q="+city+",pl&appid=ef2028e98b54649bf1f4c4582631f350", WeatherModel.class);
        model.addAttribute("weather", weatherModel);
        return "index";
    }



    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
