/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mcheck.controller;

import com.mcheck.model.Clients;
import com.mcheck.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.samples.petclinic.web.PetValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Collection;

/**
 * @author Teodor Rupi
 */
@Controller
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

//    @RequestMapping("/clients")
//    public String showClientsList(@RequestParam("foo") String foo, Model model) {
//        Clients clients = new Clients();
//        clients.getClientList().addAll(this.clientService.findClients(foo));
//        model.addAttribute("clients", clients);
//        return "pages/clients";
//    }
//
//    @RequestMapping("/clients")
//    public String getClientListByName(@RequestParam("name") String name, Model model) {
//        Clients clients = new Clients();
//        clients.getClientList().addAll(this.clientService.findClients(name));
//        model.addAttribute("clients", clients);
//        return "pages/clients";
//    }

    @RequestMapping("/clients")
    public String getClients(@RequestParam("location") String location, @RequestParam("speciality") String speciality, Model model) {
        Clients clients = new Clients();
        clients.getClientList().addAll(this.clientService.findClientsWithParams(location, speciality));
        model.addAttribute("clients", clients);
        return "pages/clients";
    }

}
