package com.jpapractice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaPracticeApplicationTests
{
	Calculator c = new Calculator();
	
	@Test
	void contextLoads()
	{
	}
	
	@Test
	void testSum()
	{
		int res = c.sum(10, 20);
		
		assertThat(res).isEqualTo(30);
	}
	
	@Test
	void testProduct()
	{
		int res = c.product(10, 20);
		
		assertThat(res).isEqualTo(200);
	}
}