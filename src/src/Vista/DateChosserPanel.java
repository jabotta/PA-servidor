/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

 

import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.Locale;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * A demonstration panel including several JDateChoosers.
 * 
 * @author Kai Toedter
 * @version $LastChangedRevision: 153 $
 * @version $LastChangedDate: 2011-06-09 16:49:22 +0200 (Do, 09 Jun 2011) $
 */
public class DateChosserPanel extends JPanel implements PropertyChangeListener {
	private static final long serialVersionUID = -1282280858252793253L;
	private final JComponent components;

	public DateChosserPanel() {
		setName("JDateChooser");

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		setLayout(gridbag);

		 
		components = new JDateChooser();
		addEntry(" ", components , gridbag);		 
	}

	private void addEntry(String text, JComponent component, GridBagLayout grid) {
	 
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1.0;
		c.fill = GridBagConstraints.BOTH;
 
		c.gridwidth = GridBagConstraints.REMAINDER;
		grid.setConstraints(component, c);
		add(component);
		JPanel blankLine = new JPanel() {
			private static final long serialVersionUID = 4514530330521503732L;

			public Dimension getPreferredSize() {
				return new Dimension(10, 3);
			}
		};
		grid.setConstraints(blankLine, c);
		add(blankLine);
	}

	/**
	 * Gets the date format string.
	 * 
	 * @return Returns the dateFormatString.
	 */
	public String getDateFormatString() {
		return ((JDateChooser) components).getDateFormatString();
	}

	/**
	 * Sets the date format string. E.g "MMMMM d, yyyy" will result in "July 21,
	 * 2004" if this is the selected date and locale is English.
	 * 
	 * @param dfString
	 *            The dateFormatString to set.
	 */
	public void setDateFormatString(String dfString) {
		 
			((JDateChooser) components).setDateFormatString(dfString);
		 
	}

	/**
	 * Returns the date. If the JDateChooser is started with an empty date and
	 * no date is set by the user, null is returned.
	 * 
	 * @return the current date
	 */
	public Date getDate() {
		return ((JDateChooser) components).getDate();
	}

	/**
	 * Sets the date. Fires the property change "date" if date != null.
	 * 
	 * @param date
	 *            the new date.
	 */
	public void setDate(Date date) {
			((JDateChooser) components).setDate(date);
		
	}

	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("date")) {
			setDate((Date) evt.getNewValue());
		}
	}

	/**
	 * Returns the locale of the first JDateChooser.
	 */
	public Locale getLocale() {
		return ((JDateChooser) components).getLocale();
	}

	/**
	 * Sets the locale of the first 4 JDateChoosers.
	 */
	public void setLocale(Locale locale) {
			components.setLocale(locale);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Component#isEnabled()
	 */
	public boolean isEnabled() {
		return ((JDateChooser) components).isEnabled();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#setEnabled(boolean)
	 */
	public void setEnabled(boolean enabled) {
			components.setEnabled(enabled);
	}

	public Date getMinSelectableDate() {
		return ((JDateChooser) components ).getMinSelectableDate();
	}

	public void setMinSelectableDate(Date date) {
		for (int i = 0; i < 4; i++) {
			((JDateChooser) components).setMinSelectableDate(date);
		}
	}

	public Date getMaxSelectableDate() {
		return ((JDateChooser) components).getMaxSelectableDate();
	}

	public void setMaxSelectableDate(Date date) {
		for (int i = 0; i < 4; i++) {
			((JDateChooser) components).setMaxSelectableDate(date);
		}
	}
}