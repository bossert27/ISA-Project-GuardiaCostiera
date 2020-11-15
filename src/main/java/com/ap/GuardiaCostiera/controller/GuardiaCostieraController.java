
package com.ap.GuardiaCostiera.controller;

import com.ap.GuardiaCostiera.model.Capitanerie;
import com.ap.GuardiaCostiera.model.Comandanti;
import com.ap.GuardiaCostiera.model.Componenti;
import com.ap.GuardiaCostiera.model.Interventi;
import com.ap.GuardiaCostiera.model.Squadre;
import com.ap.GuardiaCostiera.service.CapitanerieService;
import com.ap.GuardiaCostiera.service.ComandantiService;
import com.ap.GuardiaCostiera.service.ComponentiService;
import com.ap.GuardiaCostiera.service.InterventiService;
import com.ap.GuardiaCostiera.service.SquadreService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Marco
 */
@Controller
public class GuardiaCostieraController {
    
    
    
    @RequestMapping (value = "/",method = RequestMethod.GET)
    public ModelAndView homePage()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("homePage");
        return mav;
    }
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    //COMANDANTI
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    
    
    @Autowired
    private ComandantiService comandantiService;
    
    /* 
     * notazione che serve a richiedere la root del sito quando la richiesta è get 
     * quando la richiesta è / viene eseguito questo metodo,
     * che chiede la vista che si chiama home,
     * risolta cercando home nella cartella templates
     */
    @RequestMapping (value = "/co",method = RequestMethod.GET)
    public ModelAndView home()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        //aggiungo attributo e restituisce lista di oggetti nota al template home
        List<Comandanti> listaComandanti = comandantiService.getAll();
        mav.addObject("listaComandanti", listaComandanti);
        //permette di aggiungere un nuovo comandante dalla pagina web
        mav.addObject("comandanti", new Comandanti());
        return mav;
    }
    
    /**
     * @param comandanti  salva il valore passato
     * @param bindingResult indicatore di errori, impostato
     * @return mav 
     * direttamente da Spring.
     */
    @RequestMapping (value = "/add/co",method = RequestMethod.POST)
    public ModelAndView add(@Valid Comandanti comandanti, BindingResult bindingResult)
    {
        ModelAndView mav = new ModelAndView();
        comandantiService.saveComandanti(comandanti);
        List<Comandanti> listaComandanti = comandantiService.getAll();
        mav.addObject("listaComandanti", listaComandanti);
        mav.addObject("comandanti", new Comandanti());
        mav.setViewName("home");
        return mav;
    }
    
    @RequestMapping (value = "/edit/{comandantiId}",method = RequestMethod.GET)
    public ModelAndView update(@PathVariable String comandantiId)
    {
        ModelAndView mav = new ModelAndView();
        mav.addObject("comandanti", comandantiService.findById(comandantiId));
        mav.setViewName("edit_comandanti");
        return mav;
    }
    
    @RequestMapping (value = "/edit",method = RequestMethod.POST)
    public ModelAndView do_update(@Valid Comandanti c, BindingResult bindingResult)
    {
        System.out.println(c.getCf());
        comandantiService.saveComandanti(c);
        return new ModelAndView("redirect:/co");
    }
    
    @RequestMapping (value = "/delete/{comandantiId}",method = RequestMethod.GET)
    public ModelAndView delete_confirm(@PathVariable String comandantiId)
    {
        ModelAndView mav = new ModelAndView();
        Optional<Comandanti> comandantiFound = comandantiService.findById(comandantiId);
        
        mav.addObject("comandanti", comandantiFound.get());
        mav.setViewName("delete_confirm");
        return mav;
    }
    
    @RequestMapping (value = "/do_delete",method = RequestMethod.POST)
    public ModelAndView do_delete(@Valid Comandanti c, BindingResult bindingResult)
    {
        System.out.println(c.getCf());
        comandantiService.deleteComandanti(c.getCf());
        return new ModelAndView("redirect:/co");
    }
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    //CAPITANERIE
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    
    @Autowired
    private CapitanerieService capitanerieService;
    
    
    @RequestMapping (value = "/cap/",method = RequestMethod.GET)
    public ModelAndView homeCap()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("homeCap");
        List<Capitanerie> listaCapitanerie = capitanerieService.getAllCap();
        List<Comandanti> listaComandanti = comandantiService.getAll();
        mav.addObject("listaComandanti", listaComandanti);
        mav.addObject("listaCapitanerie", listaCapitanerie);
        mav.addObject("capitanerie", new Capitanerie());
        return mav;
        
    }
    
    
    @RequestMapping (value = "/cap/add",method = RequestMethod.POST)
    public ModelAndView addCap(@Valid Capitanerie capitanerie, BindingResult bindingResult)
    {
        ModelAndView mav = new ModelAndView();
        capitanerieService.saveCapitanerie(capitanerie);
        List<Capitanerie> listaCapitanerie = capitanerieService.getAllCap();
        mav.addObject("listaCapitanerie", listaCapitanerie);
        List<Comandanti> listaComandanti = comandantiService.getAll();
        mav.addObject("listaComandanti", listaComandanti);
        mav.addObject("capitanerie", new Capitanerie());
        mav.setViewName("homeCap");
        return mav;
        
    }
    
    
    @RequestMapping (value = "/editCap/{capitanerieId}",method = RequestMethod.GET)
    public ModelAndView updateCap(@PathVariable String capitanerieId)
    {
        ModelAndView mav = new ModelAndView();
        mav.addObject("capitanerie", capitanerieService.findByIdCap(capitanerieId));
        List<Comandanti> listaComandanti = comandantiService.getAll();
        mav.addObject("listaComandanti", listaComandanti);
        mav.setViewName("edit_capitanerie");
        return mav;
    }
    
    @RequestMapping (value = "/editCap",method = RequestMethod.POST)
    public ModelAndView do_updateCap(@Valid Capitanerie c, BindingResult bindingResult)
    {
        System.out.println(c.getCodice_cap());
        capitanerieService.saveCapitanerie(c);
        return new ModelAndView("redirect:/cap/");
    }
    
    @RequestMapping (value = "/deleteCap/{capitanerieId}",method = RequestMethod.GET)
    public ModelAndView delete_confirmCap(@PathVariable String capitanerieId)
    {
        ModelAndView mav = new ModelAndView();
        Optional<Capitanerie> capitanerieFound = capitanerieService.findByIdCap(capitanerieId);
        
        mav.addObject("capitanerie", capitanerieFound.get());
        mav.setViewName("delete_confirmCap");
        return mav;
    }
    
    @RequestMapping (value = "/do_deleteCap",method = RequestMethod.POST)
    public ModelAndView do_deleteCap(@Valid Capitanerie c, BindingResult bindingResult)
    {
        System.out.println(c.getCodice_cap());
        capitanerieService.deleteCapitanerie(c.getCodice_cap());
        return new ModelAndView("redirect:/cap/");
    }
    
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    //SQUADRE
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    
    @Autowired
    private SquadreService squadreService;
    
    
    @RequestMapping (value = "/sq/",method = RequestMethod.GET)
    public ModelAndView homeSq()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("homeSq");
        List<Squadre> listaSquadre = squadreService.getAllSq();
        mav.addObject("listaSquadre", listaSquadre);
        List<Capitanerie> listaCapitanerie = capitanerieService.getAllCap();
        mav.addObject("listaCapitanerie", listaCapitanerie);
        mav.addObject("squadre", new Squadre());
        return mav;
    }
    
    
    @RequestMapping (value = "/sq/add",method = RequestMethod.POST)
    public ModelAndView addSq(@Valid Squadre squadre, BindingResult bindingResult)
    {
        ModelAndView mav = new ModelAndView();
        squadreService.saveSquadre(squadre);
        List<Squadre> listaSquadre = squadreService.getAllSq();
        mav.addObject("listaSquadre", listaSquadre);
        List<Capitanerie> listaCapitanerie = capitanerieService.getAllCap();
        mav.addObject("listaCapitanerie", listaCapitanerie);
        mav.addObject("squadre", new Squadre());
        mav.setViewName("homeSq");
        return mav;
    }
    
    
    @RequestMapping (value = "/editSq/{squadreId}",method = RequestMethod.GET)
    public ModelAndView updateSq(@PathVariable String squadreId)
    {
        ModelAndView mav = new ModelAndView();
        mav.addObject("squadre", squadreService.findByIdSq(squadreId));
        List<Capitanerie> listaCapitanerie = capitanerieService.getAllCap();
        mav.addObject("listaCapitanerie", listaCapitanerie);
        mav.setViewName("edit_squadre");
        return mav;
    }
    
    @RequestMapping (value = "/editSq",method = RequestMethod.POST)
    public ModelAndView do_updateSq(@Valid Squadre c, BindingResult bindingResult)
    {
        System.out.println(c.getCodice_sq());
        squadreService.saveSquadre(c);
        return new ModelAndView("redirect:/sq/");
    }
    
    @RequestMapping (value = "/deleteSq/{squadreId}",method = RequestMethod.GET)
    public ModelAndView delete_confirmSq(@PathVariable String squadreId)
    {
        ModelAndView mav = new ModelAndView();
        Optional<Squadre> squadreFound = squadreService.findByIdSq(squadreId);
        
        mav.addObject("squadre", squadreFound.get());
        mav.setViewName("delete_confirmSq");
        return mav;
    }
    
    @RequestMapping (value = "/do_deleteSq",method = RequestMethod.POST)
    public ModelAndView do_deleteSq(@Valid Squadre c, BindingResult bindingResult)
    {
        System.out.println(c.getCodice_sq());
        squadreService.deleteSquadre(c.getCodice_sq());
        return new ModelAndView("redirect:/sq/");
    }
    
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    //COMPONENTI
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    
    @Autowired
    private ComponentiService componentiService;
    
    
    @RequestMapping (value = "/com/",method = RequestMethod.GET)
    public ModelAndView homeCom()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("homeCom");
        List<Componenti> listaComponenti = componentiService.getAllCom();
        mav.addObject("listaComponenti", listaComponenti);
        List<Squadre> listaSquadre = squadreService.getAllSq();
        mav.addObject("listaSquadre", listaSquadre);
        mav.addObject("componenti", new Componenti());
        return mav;
    }
    
    
    @RequestMapping (value = "/com/add",method = RequestMethod.POST)
    public ModelAndView addCom(@Valid Componenti componenti, BindingResult bindingResult)
    {
        ModelAndView mav = new ModelAndView();
        componentiService.saveComponenti(componenti);
        List<Componenti> listaComponenti = componentiService.getAllCom();
        mav.addObject("listaComponenti", listaComponenti);
        List<Squadre> listaSquadre = squadreService.getAllSq();
        mav.addObject("listaSquadre", listaSquadre);
        mav.addObject("componenti", new Componenti());
        mav.setViewName("homeCom");
        return mav;
    }
    
    
    @RequestMapping (value = "/editCom/{componentiId}",method = RequestMethod.GET)
    public ModelAndView updateCom(@PathVariable String componentiId)
    {
        ModelAndView mav = new ModelAndView();
        mav.addObject("componenti", componentiService.findByIdCom(componentiId));
        List<Squadre> listaSquadre = squadreService.getAllSq();
        mav.addObject("listaSquadre", listaSquadre);
        mav.setViewName("edit_componenti");
        return mav;
    }
    
    @RequestMapping (value = "/editCom",method = RequestMethod.POST)
    public ModelAndView do_updateCom(@Valid Componenti c, BindingResult bindingResult)
    {
        System.out.println(c.getCodice_com());
        componentiService.saveComponenti(c);
        return new ModelAndView("redirect:/com/");
    }
    
    @RequestMapping (value = "/deleteCom/{componentiId}",method = RequestMethod.GET)
    public ModelAndView delete_confirmCom(@PathVariable String componentiId)
    {
        ModelAndView mav = new ModelAndView();
        Optional<Componenti> componentiFound = componentiService.findByIdCom(componentiId);
        
        mav.addObject("componenti", componentiFound.get());
        mav.setViewName("delete_confirmCom");
        return mav;
    }
    
    @RequestMapping (value = "/do_deleteCom",method = RequestMethod.POST)
    public ModelAndView do_deleteCom(@Valid Componenti c, BindingResult bindingResult)
    {
        System.out.println(c.getCodice_com());
        componentiService.deleteComponenti(c.getCodice_com());
        return new ModelAndView("redirect:/com/");
    }
    
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    //INTERVENTI
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    
    @Autowired
    private InterventiService interventiService;
    
    
    @RequestMapping (value = "/int/",method = RequestMethod.GET)
    public ModelAndView homeInt()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("homeInt");
        List<Interventi> listaInterventi = interventiService.getAllInt();
        mav.addObject("listaInterventi", listaInterventi);
        List<Squadre> listaSquadre = squadreService.getAllSq();
        mav.addObject("listaSquadre", listaSquadre);
        mav.addObject("interventi", new Interventi());
        return mav;
    }
    
    
    @RequestMapping (value = "/int/add",method = RequestMethod.POST)
    public ModelAndView addInt(@Valid Interventi interventi, BindingResult bindingResult)
    {
        ModelAndView mav = new ModelAndView();
        interventiService.saveInterventi(interventi);
        List<Interventi> listaInterventi = interventiService.getAllInt();
        mav.addObject("listaInterventi", listaInterventi);
        List<Squadre> listaSquadre = squadreService.getAllSq();
        mav.addObject("listaSquadre", listaSquadre);
        mav.addObject("interventi", new Interventi());
        mav.setViewName("homeInt");
        return mav;
    }
    
    
    @RequestMapping (value = "/editInt/{interventiId}",method = RequestMethod.GET)
    public ModelAndView updateInt(@PathVariable String interventiId)
    {
        ModelAndView mav = new ModelAndView();
        mav.addObject("interventi", interventiService.findByIdInt(interventiId));
        List<Squadre> listaSquadre = squadreService.getAllSq();
        mav.addObject("listaSquadre", listaSquadre);
        mav.setViewName("edit_interventi");
        return mav;
    }
    
    @RequestMapping (value = "/editInt",method = RequestMethod.POST)
    public ModelAndView do_updateInt(@Valid Interventi c, BindingResult bindingResult)
    {
        System.out.println(c.getCodice_int());
        interventiService.saveInterventi(c);
        return new ModelAndView("redirect:/int/");
    }
    
    @RequestMapping (value = "/deleteInt/{interventiId}",method = RequestMethod.GET)
    public ModelAndView delete_confirmInt(@PathVariable String interventiId)
    {
        ModelAndView mav = new ModelAndView();
        Optional<Interventi> interventiFound = interventiService.findByIdInt(interventiId);
        
        mav.addObject("interventi", interventiFound.get());
        mav.setViewName("delete_confirmInt");
        return mav;
    }
    
    @RequestMapping (value = "/do_deleteInt",method = RequestMethod.POST)
    public ModelAndView do_deleteInt(@Valid Interventi c, BindingResult bindingResult)
    {
        System.out.println(c.getCodice_int());
        interventiService.deleteInterventi(c.getCodice_int());
        return new ModelAndView("redirect:/int/");
    }
    
}
