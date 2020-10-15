package thomasmore.be.opdracht.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import thomasmore.be.opdracht.model.Brand;
import thomasmore.be.opdracht.model.Phone;
import thomasmore.be.opdracht.model.Series;
import thomasmore.be.opdracht.repositories.BrandRepository;
import thomasmore.be.opdracht.repositories.PhoneRepository;
import thomasmore.be.opdracht.repositories.SeriesRepository;

import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private SeriesRepository seriesRepository;

    private String applicatieNaam = "Mobile Shop";

    @GetMapping({"/", "/phones", "/phones/{filter}"})
    public String phones(@PathVariable(required = false) String filter,
                         Model model,
                         @RequestParam(required = false) Integer minPrijs,
                         @RequestParam(required = false) Integer maxPrijs,
                         @RequestParam(required = false) String phoneName){
        model.addAttribute("appName", applicatieNaam);
        model.addAttribute("filterButtons", new String[]{"All", "Affordable", "Expensive"});
        //Bloaters --> Long Method
        if(noFilterGiven(filter, minPrijs, maxPrijs)){
            if (filter.equals("Affordable")){
                maxPrijs = 700;
            } else if (filter.equals("Expensive")){
                minPrijs = 700;
                maxPrijs = null;
            }
        }
        model.addAttribute("phones", phoneRepository.findPhonesByCriteria(minPrijs, maxPrijs, phoneName));
        model.addAttribute("minPrijs", minPrijs);
        model.addAttribute("maxPrijs", maxPrijs);
        model.addAttribute("phoneName", phoneName);
        return "phones";
    }

    private boolean noFilterGiven(@PathVariable(required = false) String filter, @RequestParam(required = false) Integer minPrijs, @RequestParam(required = false) Integer maxPrijs) {
        return minPrijs == null && maxPrijs == null && filter != null;
    }

    @GetMapping("phone/{id}")
    public String phone(@PathVariable int id, Model model){
        model.addAttribute("appName", applicatieNaam);
        long nrOfPhones = phoneRepository.count();
        Optional<Phone> optionalPhone = phoneRepository.findById(id);
        Phone phoneFromDb = null;
        if(optionalPhone.isPresent()){
            phoneFromDb = optionalPhone.get();
        }
        model.addAttribute("idPrevPhone", id > 0 ? id - 1 : nrOfPhones - 1);
        model.addAttribute("idNextPhone", id < nrOfPhones - 1 ? id + 1 : 0);
        model.addAttribute("phone", phoneFromDb);
        return "phone";
    }

    @GetMapping("/brands")
    public String brands(Model model){
        model.addAttribute("appName", applicatieNaam);
        Iterable<Brand> filteredBrands = brandRepository.findAll();
        model.addAttribute("brands", filteredBrands);
        return "brands";
    }

    @GetMapping("/brand/{id}")
    public String brand(@PathVariable int id, Model model){
        model.addAttribute("appName", applicatieNaam);
        Optional<Brand> optionalBrand = brandRepository.findById(id);
        Brand brandFromDb = null;
        if(optionalBrand.isPresent()){
            brandFromDb = optionalBrand.get();
        }
        long nrOfBrands = brandRepository.count();
        model.addAttribute("idPrevBrand", id > 0 ? id - 1 : nrOfBrands - 1);
        model.addAttribute("idNextBrand", id < nrOfBrands - 1 ? id + 1 : 0);
        model.addAttribute("brand", brandFromDb);
        return "brand";
    }

    @GetMapping("/series")
    public String series(Model model){
        model.addAttribute("appName", applicatieNaam);
        Iterable<Series> filteredSeries = seriesRepository.findAll();
        model.addAttribute("series", filteredSeries);
        return "series";
    }

    @GetMapping("/serie/{id}")
    public String serie(@PathVariable int id, Model model){
        model.addAttribute("appName", applicatieNaam);
        Optional<Series> optionalSeries = seriesRepository.findById(id);
        Series seriesFromDb = null;
        if(optionalSeries.isPresent()){
            seriesFromDb = optionalSeries.get();
        }
        long nrOfSeries = seriesRepository.count();
        model.addAttribute("idPrevSeries", id > 0 ? id - 1 : nrOfSeries - 1);
        model.addAttribute("idNextSeries", id < nrOfSeries - 1 ? id + 1 : 0);
        model.addAttribute("serie", seriesFromDb);
        return "serie";
    }
}
