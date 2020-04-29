package com.example.PaymentServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class PaymentServices {
	
	@HystrixCommand(
			commandProperties= {
					@HystrixProperty(
					name="execution.isolation.thread.timeoutInMilliseconds",
					value="1200"
					)}

			
			,fallbackMethod = "handler")
	@GetMapping("/slectamount/{amount}")
	public String doPayment(@PathVariable int amount)
	{
		if(amount < 200) {
			throw new RuntimeException();
		}
		
		/*
		 * try { Thread.sleep(2400); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block
		 * 
		 * System.out.println("INTERRUPTED EXCEPTION"); e.printStackTrace(); }
		 */
		
		return "SUCCESS";
	}

	
	public String handler(int amount)
	{
		return "FAILURE";
		
		
	}
}
