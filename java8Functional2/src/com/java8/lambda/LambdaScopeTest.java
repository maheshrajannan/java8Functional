package com.java8.lambda;

import java.util.function.Consumer;

/**
 * @author maheshrajannan
 * 
 *         Like local and anonymous classes, lambda expressions can capture
 *         variables; they have the same access to local variables of the
 *         enclosing scope. 
 *         
 *         However, unlike local and anonymous classes, lambda
 *         expressions do not have any shadowing issues (see Shadowing for more
 *         information). 
 *         
 *         Lambda expressions are lexically scoped. This means
 *         that they do not inherit any names from a supertype or introduce a
 *         new level of scoping. 
 *         
 *         Declarations in a lambda expression are
 *         interpreted just as they are in the enclosing environment.
 * 
 */
public class LambdaScopeTest {

	public int x = 0;

	class FirstLevel {

		public int x = 1;

		/**
		 * @param x
		 */
		void methodInFirstLevel(int x) {

			/**
			 * The following statement causes the compiler to generate the error
			 * "local variables referenced from a lambda expression must be
			 * final or effectively final" in statement A:
			 * 
			 * you can directly access fields, methods, and local variables of
			 * the enclosing scope.
			 * 
			 * However, like local and anonymous classes, a lambda expression
			 * can only access local variables and parameters of the enclosing
			 * block that are final or effectively final.
			 * 
			 * Because of this assignment statement, the variable FirstLevel.x
			 * is not effectively final anymore. As a result, the Java compiler
			 * generates an error message similar to
			 * "local variables referenced from a lambda expression must be final or effectively final"
			 * where the lambda expression myConsumer tries to access the
			 * FirstLevel.x variable:
			 */
			// x = 99;

			/**
			 * If you substitute the parameter x in place of y in the
			 * declaration of the lambda expression myConsumer, then the
			 * compiler generates an error:
			 * 
			 * The compiler generates the error
			 * "variable x is already defined in method methodInFirstLevel(int)"
			 * because the lambda expression does not introduce a new level of
			 * scoping. Consequently, you can directly access fields, methods,
			 * and local variables of the enclosing scope.
			 * 
			 */
			Consumer<Integer> myConsumer = (y) -> {
				System.out.println("x = " + x); // Statement A
				System.out.println("y = " + y);
				/**
				 * the lambda expression directly accesses the parameter x of
				 * the method methodInFirstLevel. To access variables in the
				 * enclosing class, use the keyword this. In this example,
				 * this.x refers to the member variable FirstLevel.x.
				 */
				System.out.println("this.x = " + this.x);

				System.out.println("LambdaScopeTest.this.x = " + LambdaScopeTest.this.x);
			};

			myConsumer.accept(x);

		}
	}

	public static void main(String... args) {
		LambdaScopeTest st = new LambdaScopeTest();
		LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
		fl.methodInFirstLevel(23);
	}
}
