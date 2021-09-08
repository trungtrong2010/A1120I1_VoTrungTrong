package com.example.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a password to run the program");
//        System.out.print("Enter password: ");
//        while (true) {
//            String password = scanner.nextLine();
//            if (password.equals("1")) {
//                System.out.println("Ok !!!");
//                System.out.println("Ok !!!");
//                System.out.println("Ok !!!");
//                System.out.println("Ok !!!");
//                System.out.println("Ok !!!");
//                System.out.println("Ok !!!");
//                System.out.println("Ok !!!");
//                System.out.println("Ok !!!");
//                System.out.println("Ok !!!");
//                System.out.println("Ok !!!");
//                int a= 0;
//                while (a < 1000000) {
//                    a++;
//                    System.err.println("  .   ____          _            __ _ _\n" +
//                            " /\\\\ / ___'_ __ _ _(_)_ __  __ _ \\ \\ \\ \\\n" +
//                            "( ( )\\___ | '_ | '_| | '_ \\/ _` | \\ \\ \\ \\\n" +
//                            " \\\\/  ___)| |_)| | | | | || (_| |  ) ) ) )\n" +
//                            "  '  |____| .__|_| |_|_| |_\\__, | / / / /\n" +
//                            " =========|_|==============|___/=/_/_/_/\n" +
//                            " :: Spring Boot ::                (v2.5.4)\n" +
//                            "\n" +
//                            "2021-08-26 21:57:45.217  INFO 11940 --- [           main] com.example.blog.BlogApplication         : Starting BlogApplication using Java 1.8.0_251 on DESKTOP-BGNFUQF with PID 11940 (E:\\A1120I1\\Module4\\12.AJAX\\bt\\blog\\build\\classes\\java\\main started by Lenovo in E:\\A1120I1\\Module4\\12.AJAX\\bt\\blog)\n" +
//                            "2021-08-26 21:57:45.222  INFO 11940 --- [           main] com.example.blog.BlogApplication         : No active profile set, falling back to default profiles: default\n" +
//                            "2021-08-26 21:57:46.249  INFO 11940 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.\n" +
//                            "2021-08-26 21:57:46.310  INFO 11940 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 51 ms. Found 1 JPA repository interfaces.\n" +
//                            "2021-08-26 21:57:46.857  INFO 11940 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 2110 (http)\n" +
//                            "2021-08-26 21:57:46.867  INFO 11940 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]\n" +
//                            "2021-08-26 21:57:46.867  INFO 11940 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.52]\n" +
//                            "2021-08-26 21:57:47.020  INFO 11940 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext\n" +
//                            "2021-08-26 21:57:47.020  INFO 11940 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1712 ms\n" +
//                            "2021-08-26 21:57:47.220  INFO 11940 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]\n" +
//                            "2021-08-26 21:57:47.272  INFO 11940 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.4.32.Final\n" +
//                            "2021-08-26 21:57:47.420  INFO 11940 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}\n" +
//                            "2021-08-26 21:57:47.536  INFO 11940 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...\n" +
//                            "2021-08-26 21:57:48.240  INFO 11940 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.\n" +
//                            "2021-08-26 21:57:48.263  INFO 11940 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.MySQL8Dialect\n" +
//                            "2021-08-26 21:57:48.987  INFO 11940 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]\n" +
//                            "2021-08-26 21:57:48.999  INFO 11940 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'\n" +
//                            "2021-08-26 21:57:49.530  WARN 11940 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning\n" +
//                            "2021-08-26 21:57:50.074  INFO 11940 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 2110 (http) with context path ''\n" +
//                            "2021-08-26 21:57:50.086  INFO 11940 --- [           main] com.example.blog.BlogApplication         : Started BlogApplication in 5.529 seconds (JVM running for 9.204)\n");
//                }
//                break;
//            }
//            System.err.print("PASSWORD FAILED !!!");
//        }
        SpringApplication.run(BlogApplication.class, args);
    }

}
