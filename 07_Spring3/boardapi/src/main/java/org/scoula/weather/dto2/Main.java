package org.scoula.weather.dto2;

import lombok.Data;

@Data
public class Main{
	private Object temp;
	private Object tempMin;
	private int grndLevel;
	private int humidity;
	private int pressure;
	private int seaLevel;
	private Object feelsLike;
	private Object tempMax;
}