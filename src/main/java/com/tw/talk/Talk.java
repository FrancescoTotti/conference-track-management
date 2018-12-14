package com.tw.talk;

public class Talk {
	
	private String name;
	
	private long interval;
	
	public Talk() {
		
	}

	public Talk(String name, long interval) {
		this.name = name;
		this.interval = interval;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the interval
	 */
	public long getInterval() {
		return interval;
	}

	/**
	 * @param interval the interval to set
	 */
	public void setInterval(long interval) {
		this.interval = interval;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Talk [name=" + name + ", interval=" + interval + "]";
	}

	
}
