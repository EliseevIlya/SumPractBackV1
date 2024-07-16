package com.example.sumpractbackv1.util.specifications;

import jakarta.persistence.criteria.*;

public class StaticUtils {

	public static String likePattern(String value) {
		return "%" + value + "%";
	}

	public static Predicate likeBic(CriteriaBuilder criteriaBuilder, Expression<?> x, String value) {
		return criteriaBuilder.like(
			criteriaBuilder.function(
				"to_char",
				String.class,
				x,
				criteriaBuilder.literal("000000000")
			),
			likePattern(value)
		);
	}

	public static Predicate likeTenD(CriteriaBuilder criteriaBuilder, Expression<?> x, String value) {
		return criteriaBuilder.like(
			criteriaBuilder.function(
				"to_char",
				String.class,
				x,
				criteriaBuilder.literal("0000000000")
			),
			likePattern(value)
		);
	}
	
}
