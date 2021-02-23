/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myFuzzyProject;

import javax.swing.JOptionPane;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

/**
 *
 * @author juan
 */
public class on {
    private net.sourceforge.jFuzzyLogic.FIS fis;
    private net.sourceforge.jFuzzyLogic.plot.JDialogFis jdialogofis;
    public on(){
        String filename = "C:\\Users\\juan\\Documents\\NetBeansProjects\\ProyectoLD\\src\\com\\myFuzzyProject\\tipper.fcl";
		FIS fis = FIS.load(filename, true);
                jdialogofis = new net.sourceforge.jFuzzyLogic.plot.JDialogFis(fis);
		if (fis == null) {
			System.err.println("no carga: '" + filename + "'");
			System.exit(1);
		}

		// Get default function block
		FunctionBlock fb = fis.getFunctionBlock(null);
                //JOptionPane.showMessageDialog(null,fb);
		// Set inputs
		fb.setVariable("Medicamento", 7.5);
		fb.setVariable("Tratamiento", 3.5);

		// Evaluate
		fb.evaluate();

		// Show output variable's chart
		fb.getVariable("Tipo").defuzzify();

		// Print ruleSet
		//System.out.println(fb);
               
                JOptionPane.showMessageDialog(null, "Tipo: " + fb.getVariable("Tipo").getValue());
		System.out.println("Tipo: " + fb.getVariable("Tipo").getValue());
                

	}
    }

