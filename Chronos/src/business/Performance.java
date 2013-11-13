/* _________________________________________________________ */
/* _________________________________________________________ */
/**
 * Fichier : Performance.java
 * 
 * Créé le 31 oct. 2013 à 13:12:58
 * 
 * Auteur : Charles NEAU
 */
package business;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Locale;

/* _________________________________________________________ */
/**
 * The Class Performance.
 * Un {@link Performance} est un le résultat d'une performance.
 * Il contient le temps du chronomètre, la distance parcouru,
 * ainsi que la date de la création de ce temps.
 * 
 * @author Charles NEAU
 */
public class Performance
{
	/** The chrono. */
	private final long	chrono;
	/** La date. */
	private String		date;
	/** The distance. */
	private final int	distance;

	/* _________________________________________________________ */
	/**
	 * Instantiates a new resultat.
	 * 
	 * @param chrono
	 *            the chrono
	 * @param distance
	 *            the distance
	 */
	public Performance(final long chrono, final int distance)
	{
		super();
		formatDate();
		this.chrono = chrono;
		this.distance = distance;
	}

	/* _________________________________________________________ */
	/**
	 * Init date format.
	 */
	private void formatDate()
	{
		final Calendar cal = Calendar.getInstance(Locale.FRANCE);
		final java.text.DateFormat dateF = java.text.DateFormat
				.getDateInstance(java.text.DateFormat.MEDIUM);
		date = dateF.format(cal.getTime());
	}

	/* _________________________________________________________ */
	/**
	 * Retourne la valeur du champ chrono.
	 * 
	 * @return la valeur du champ chrono.
	 */
	public long getChrono()
	{
		return chrono;
	}

	/* _________________________________________________________ */
	/**
	 * Retourne la valeur du champ date.
	 * 
	 * @return la valeur du champ date.
	 */
	public String getDate()
	{
		return date;
	}

	/* _________________________________________________________ */
	/**
	 * Retourne la valeur du champ distance.
	 * 
	 * @return la valeur du champ distance.
	 */
	public int getDistance()
	{
		return distance;
	}
	
	/**
	 * Methode de mise en forme du rendu chronometre.
	 * 
	 * @param timeElapsed
	 *            the time elapsed
	 * @return the string
	 */
	public String miseEnForme(final long timeElapsed)
	{
		final DecimalFormat df = new DecimalFormat("00");
		int remaining = (int) (timeElapsed % (3600 * 1000));
		final int minutes = remaining / (60 * 1000);
		remaining = remaining % (60 * 1000);
		final int seconds = remaining / 1000;
		remaining = remaining % (1000);
		final int milliseconds = ((((int) timeElapsed % 1000) / 10));
		final StringBuilder builder = new StringBuilder();
		builder.append(df.format(minutes)).append("'");
		builder.append(df.format(seconds)).append("\"");
		builder.append(df.format(milliseconds));
		return builder.toString();
	}

	/* _________________________________________________________ */
	/**
	 * @return Description performance.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		final StringBuilder build = new StringBuilder();
		build.append("Le ").append(date).append(", ");
		build.append(miseEnForme(chrono)).append(" (").append(distance).append("m)");
		return build.toString();
	}
}
/* _________________________________________________________ */
/*
 * Fin du fichier Performance.java.
 * /*_________________________________________________________
 */
