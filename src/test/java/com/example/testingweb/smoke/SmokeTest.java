package com.example.testingweb.smoke;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.testingweb.HomeController;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class SmokeTest {

	@Autowired
	private HomeController controller;

	@Test
	@Order(1)
	public void contextLoads() throws Exception {
		System.out.println("dans contextLoads");
		assertThat(controller).isNotNull();
	}
	@Test
	@Order(2)
	public void test() throws Exception {
		System.out.println("dans test");
		assertTrue(true);
	}
	@BeforeEach
	public void testBeforeEach() {
		System.out.println("dans testBeforeEach");
	}
	@AfterEach
	public void testAfterEach() {
		System.out.println("dans testAfterEach");
	}
	@BeforeAll
	public static void testBeforeAll() {
		System.out.println("dans testBeforeAll");
	}
	@AfterAll
	public static void testAfterAll() {
		System.out.println("dans testAfterAll");
	}
}
