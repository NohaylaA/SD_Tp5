package org.example;

import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

public class Main
{
    public static void main(String[] args)
    {
        BanqueService proxy = new BanqueWS().getBanqueServicePort();
        System.out.println(proxy.conversionEutoToDH(90.0));
        System.out.println("-----------------------");
        Compte compte = proxy.getCompte(4);
        System.out.println(compte.getCode());
        System.out.println(compte.getSolde());
        System.out.println(compte.getDateCreation());
        System.out.println("-----------------------");
        proxy.listComptes().forEach(cp -> {
            System.out.println("-----------------------");
            System.out.println(cp.getCode());
            System.out.println(cp.getSolde());
            System.out.println(cp.getDateCreation());
        });
    }
}