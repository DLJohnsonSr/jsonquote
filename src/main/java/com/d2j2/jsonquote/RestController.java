package com.d2j2.jsonquote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RestController {

    @Autowired
    HttpServletRequest request;

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("/quote")
    public @ResponseBody String showQuote() {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        return quote.getValue().getQuote();
    }
    @RequestMapping("/horo")
    public String showHoroscope(Model model, HttpServletRequest request) {
//    public @ResponseBody String showHoroscope(Model model, HttpServletRequest request) {
        int month = new Integer(request.getParameter("month"));
        int day = new Integer(request.getParameter("day"));
        String horoscopeURL;
        horoscopeURL = "http://horoscope-api.herokuapp.com/horoscope/week/"+returnSunsign(month, day);
        RestTemplate restTemplate = new RestTemplate();
        Horoscope horoscope = restTemplate.getForObject(horoscopeURL, Horoscope.class);
//        return horoscope.getSunsign()+horoscope.getWeek()+horoscope.getHoroscope();
        model.addAttribute("horoscope", horoscope);
        return "horoscopepage";
    }
    public static String returnSunsign(int month, int day){
        String sunsign ="";
        switch (month){
            case 1: if(day>19) {
                sunsign = "aquarius";
                break;
            }else{
                sunsign = "capricorn";
                break;
            }
            case 2: if(day>18) {
                sunsign = "pisces";
                break;
            }else{
                sunsign = "aquarius";
                break;
            }
            case 3: if(day>20) {
                sunsign = "ries";
                break;
            }else{
                sunsign = "pisces";
                break;
            }
            case 4: if(day>19) {
                sunsign = "taurus";
                break;
            }else{
                sunsign = "aries";
                break;
            }
            case 5: if(day>20) {
                sunsign = "gemini";
                break;
            }else{
                sunsign = "taurus";
                break;
            }
            case 6: if(day>20) {
                sunsign = "cancer";
                break;
            }else{
                sunsign = "gemini";
                break;
            }
            case 7: if(day>22) {
                sunsign = "leo";
                break;
            }else{
                sunsign = "cancer";
                break;
            }
            case 8: if(day>22) {
                sunsign = "virgo";
                break;
            }else{
                sunsign = "leo";
                break;
            }
            case 9: if(day>22) {
                sunsign = "libra";
                break;
            }else{
                sunsign = "virgo";
                break;
            }
            case 10: if(day>22) {
                sunsign = "scorpio";
                break;
            }else{
                sunsign = "libra";
                break;
            }
            case 11: if(day>21) {
                sunsign = "sagittarius";
                break;
            }else{
                sunsign = "scorpio";
                break;
            }
            case 12: if(day>20) {
                sunsign = "capricorn";
                break;
            }else{
                sunsign = "sagittarius";
                break;
            }
        }
        return sunsign;
    }
}
