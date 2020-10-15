package thomasmore.be.opdracht.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import thomasmore.be.opdracht.model.Brand;
import thomasmore.be.opdracht.model.Phone;
import thomasmore.be.opdracht.model.Series;
import thomasmore.be.opdracht.repositories.BrandRepository;
import thomasmore.be.opdracht.repositories.PhoneRepository;
import thomasmore.be.opdracht.repositories.SeriesRepository;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private SeriesRepository seriesRepository;

    private String applicatieNaam = "Mobile Shop";

    @GetMapping("/phone/edit/{phoneId}")
    public String editPhone(@PathVariable(required = false) int phoneId, Model model) {
        model.addAttribute("appName", applicatieNaam);
        Optional<Phone> optionalPhone = phoneRepository.findById(phoneId);
        Phone phoneFromDb = null;
        if (optionalPhone.isPresent()) {
            phoneFromDb = optionalPhone.get();
        }
        model.addAttribute("brands", brandRepository.findAll());
        model.addAttribute("series", seriesRepository.findAll());
        model.addAttribute("phone", phoneFromDb);
        return "admin/edit-phone";
    }

    @PostMapping({"/edit-phone/{phoneId}"})
    public String editPhonePost(@PathVariable(required = false) int phoneId,
                                @RequestParam String phoneName,
                                @RequestParam int phonePrice,
                                @RequestParam String phoneBrand,
                                @RequestParam String phoneSeries,
                                Model model) {
        Optional<Phone> phoneFromDb = phoneRepository.findById(phoneId);
        if (phoneFromDb.isPresent()) {
            Phone phone = phoneFromDb.get();
            setPhone(phoneName, phonePrice, phoneBrand, phoneSeries, phone);
        }
        return "redirect:/phone/" + phoneId;
    }

    private void setPhone(@RequestParam String phoneName, @RequestParam int phonePrice, @RequestParam String phoneBrand, @RequestParam String phoneSeries, Phone phone) {
        phone.setName(phoneName);
        phone.setPrijs(phonePrice);
        Optional<Brand> brand = brandRepository.findBrandByBrandNameEquals(phoneBrand);
        Optional<Series> series = seriesRepository.findSeriesBySeriesNameEquals(phoneSeries);
        brand.ifPresent(phone::setBrand);
        series.ifPresent(phone::setSeries);
        phoneRepository.save(phone);
    }

    @GetMapping("/phone/create")
    public String createPhone(Model model) {
        model.addAttribute("appName", applicatieNaam);
        model.addAttribute("brands", brandRepository.findAll());
        model.addAttribute("series", seriesRepository.findAll());
        return "admin/create-phone";
    }

    @PostMapping({"/create-phone"})
    public String createPhonePost(@RequestParam String phoneName,
                                @RequestParam Integer phonePrice,
                                @RequestParam String phoneBrand,
                                @RequestParam String phoneSeries,
                                Model model) {
        if(isEveryInfoFilledIn(phoneName, phonePrice, phoneBrand, phoneSeries)){
            Phone phone = new Phone();
            setPhone(phoneName, phonePrice, phoneBrand, phoneSeries, phone);
        }
        return "redirect:/phones";
    }

    private boolean isEveryInfoFilledIn(@RequestParam String phoneName, @RequestParam Integer phonePrice, @RequestParam String phoneBrand, @RequestParam String phoneSeries) {
        return phoneName != null && phonePrice != null && phoneBrand != null && phoneSeries != null;
    }
}
