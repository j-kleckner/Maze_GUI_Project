import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.*;

import javax.swing.*;

public class Print implements Printable, ActionListener {
	JTextPane textAreaToPrint = viewMaze.textArea;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(this);
		boolean ok = job.printDialog();
		
		if(ok) {
			try {
				job.print();
			} catch (PrinterException ex) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		// TODO Auto-generated method stub
		if (pageIndex > 0) {
			return NO_SUCH_PAGE;
		}
		Graphics2D g2d = (Graphics2D)graphics;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		
		textAreaToPrint.printAll(graphics);
		
		return PAGE_EXISTS;
	}
	
}