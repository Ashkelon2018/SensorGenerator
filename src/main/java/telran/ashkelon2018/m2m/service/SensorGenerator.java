package telran.ashkelon2018.m2m.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import telran.ashkelon2018.m2m.dto.Sensor;

@EnableBinding(Source.class)
public class SensorGenerator {
	ObjectMapper mapper = new ObjectMapper();
	@Value("${minId}")
	int minId;
	@Value("${maxId}")
	int maxId;
	@Value("${minData}")
	int minData;
	@Value("${maxData}")
	int maxData;
	
	@InboundChannelAdapter(Source.OUTPUT)
	public String sendSensorData() throws JsonProcessingException {
		int id = getRandomId();
		long timestamp = System.currentTimeMillis();
		int data = getRandomData();
		Sensor sensor = new Sensor(id,timestamp,data);
		String sensorData = mapper.writeValueAsString(sensor);
		return sensorData;
	}

	private int getRandomData() {
		return getRandomNumber(minData, maxData);
	}

	private int getRandomId() {
		return getRandomNumber(minId, maxId);
	}

	private int getRandomNumber(int min, int max) {
		return (int) (min + Math.random()*(max + 1 - min));
	}

}
