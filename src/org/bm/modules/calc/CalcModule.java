package org.bm.modules.calc;

import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;

import javax.swing.KeyStroke;

import org.bm.modules.calc.frame.CalcFrame;
import org.bm.modules.shared.IModule;
import org.bm.modules.shared.ModuleFrame;

public class CalcModule implements IModule {

   private final ModuleFrame frame = new CalcFrame();

   private Boolean active = Boolean.TRUE;

   @Override
   public void attach() {
      frame.initComponents();
   }

   @Override
   public void deattach() {
      try {
         frame.setVisible(false);
         frame.setClosed(true);
      } catch (PropertyVetoException e) {}
      frame.getComponentContainer().getWindowManager().removeWindow(frame);
   }

   @Override
   public int getMenuIndex() {
      return IModule.MENU_FILE;
   }

   @Override
   public int getMenuItemIndex() {
      return 0;
   }

   @Override
   public String getName() {
      return "Calc";
   }

   @Override
   public boolean hasMnemonic() {
      return true;
   }

   @Override
   public int getMnemonic() {
      return KeyEvent.VK_L;
   }

   @Override
   public boolean hasAccelerator() {
      return false;
   }

   @Override
   public KeyStroke getAccelerator() {
      return null;
   }

   @Override
   public ModuleFrame getModuleFrame() {
      return frame;
   }

   @Override
   public String getVersion() {
      return "0.0.0.1";
   }

   @Override
   public Boolean isActive() {
      return active;
   }

   @Override
   public void setActive(Boolean active) {
      this.active = active;
   }

   @Override
   public Boolean isDeactivable() {
      return true;
   }

   @Override
   public String toString() {
      return getName() + " [" + getVersion() + "]";
   }
}
