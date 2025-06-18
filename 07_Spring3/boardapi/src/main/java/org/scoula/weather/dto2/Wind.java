package org.scoula.weather.dto2;

import lombok.Data;

@Data
public class Wind{
	private int deg;
	private Object speed;
	private Object gust;
}