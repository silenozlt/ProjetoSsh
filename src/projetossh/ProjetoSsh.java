/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetossh;

import java.util.Scanner;

/**
 *
 * @author Cassio
 */
public class ProjetoSsh {

    public static void main(String... args) throws Exception {

        Runtime r = Runtime.getRuntime();
        Process p = r.exec(new String[]{"/bin/sh", "-c", "ifconfig | grep 'inet ' | awk '{print $2}' | sed 's/addr://'"});
        Scanner scanner = new Scanner(p.getInputStream());
        String resultado = scanner.next();
        System.out.println(resultado);
    }
}
