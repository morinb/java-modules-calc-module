package org.bm.modules.calc.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JTextField;

public class ButtonActionListener implements ActionListener {

   private final JTextField outputTextField;

   private final JTextField memoryTextField;

   private final String action;

   private final Stack<String> stack;

   private static String lastAction = "";

   private static String memory = "0";

   private static boolean shouldRestart = false;

   public ButtonActionListener(JTextField output, JTextField memory, String action, Stack<String> stack) {
      super();
      this.outputTextField = output;
      this.memoryTextField = memory;
      this.action = action;
      this.stack = stack;
      shouldRestart = false;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      switch (action) {
      case "C":
         break;
      case "CE":
         break;
      case "Del":
         break;
      case "=":
         compute();
         break;
      case "MS":
         memory = stack.peek();
         memoryTextField.setText(memory);
         shouldRestart = true;
         break;
      case "MC":
         memory = "0";
         memoryTextField.setText(memory);
         shouldRestart = true;
         break;
      case "M+":
         memory = Double.toString(Double.parseDouble(stack.peek()) + Double.parseDouble(memory));
         memoryTextField.setText(memory);
         shouldRestart = true;
         break;
      case "MR":
         setValue(memory);
         shouldRestart = true;
         break;
      case "/":
      case "*":
      case "-":
      case "+":
      case "Mod":
         if (lastAction.isEmpty()) {
            lastAction = action;
         } else {
            compute();
            lastAction = action;
         }
         shouldRestart = true;
         break;
      case "Inv":
         setValue(1 / getValue());
         shouldRestart = true;
         break;
      case "+/-":
         setValue((-1) * getValue());
         shouldRestart = true;
         break;
      case "Sqrt":
         setValue(Math.sqrt(getValue()));
         shouldRestart = true;
         break;
      default:
         if (stack.isEmpty() || shouldRestart) {
            stack.push(action);
            shouldRestart = false;
         } else {
            String value = stack.pop() + action;
            stack.push(value);
         }
         break;
      }
      outputTextField.setText(stack.peek());

   }

   private Double getValue() {
      return Double.parseDouble(stack.pop());
   }

   private void setValue(Double value) {
      stack.push(value.toString());
   }

   private void setValue(String value) {
      stack.push(value);
   }

   private void compute() {
      switch (lastAction) {
      case "+":
         setValue(getValue() + getValue());
         break;
      case "*":
         setValue(getValue() * getValue());
         break;
      case "-":
         Double v2 = getValue();
         Double v1 = getValue();
         setValue(v1 - v2);
         break;
      case "/":
         v2 = getValue();
         v1 = getValue();
         setValue(v1 / v2);
         break;
      case "Mod":
         v2 = getValue();
         v1 = getValue();
         setValue(v1 % v2);
         break;
      default:
         break;
      }
      lastAction = "";

   }

}
