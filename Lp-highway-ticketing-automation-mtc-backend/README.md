<h3 align="center">:rotating_light: :construction:&ensp;&ensp;Work In Progress&ensp;&ensp;:construction: :rotating_light:</h3>
<h1 align="center"> Highway Ticketing System -(HTA) </h1>
<h3 align="center"> Backend Services </h3>
LP Training code base that belongs to my office work.

<h2>License</h2>

<p>Licenses this source under the <u>MIT License</u>,You may not use this file except in compliance with the License.</p>
<!-- Badges -->
<p align="left">
  <a href="LICENSE.md">
    <img src="https://img.shields.io/badge/License-MIT-blue.svg" alt="License: MIT" height="18">
  </a>
</p>

[![Maven](https://img.shields.io/badge/maven%20central-2.0-yellowgreen)](http://stackoverflow.com/questions/tagged/maven)
[![OpenIssues](https://img.shields.io/github/issues/sriThariduSangeeth/Highway-ticketing-automation-for-mtc-lp?style=social)](https://github.com/sriThariduSangeeth/Highway-ticketing-automation-for-mtc-lp/issues)
<img src="https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg" alt="License: MIT" height="25">
  <a>
    <img src="https://img.shields.io/badge/Build-Passed-green" alt="Build: Passed" height="18">
  </a>
 <a>
    <img src="https://raw.githubusercontent.com/acervenky/animated-github-badges/master/assets/devbadge.gif" alt="Build: Passed" height="18">
  </a>

<h2>Content&ensp;&ensp;:book: :book:</h2>

<ul>
    <li>lp-hta-api-gateway-service</li>
      <ul>
        <li>Spring API GateWay :
         > <p>Spring Cloud Gateway aims to provide a simple, yet effective way to route to APIs and provide cross cutting concerns to them such as: security, monitoring/metrics, and resiliency.</p>
        </li>
        <li>Spring Cloud Circuit breaker :
          <p>Spring Cloud Circuit breaker provides an abstraction across different circuit breaker implementations. It provides a consistent API to use in your applications allowing you the developer to choose the circuit breaker implementation that best fits your needs for your app.</p>
        </li>
      </ul>
    <li>lp-hta-cloud-common-models</li>
      <ul>
        <li>Spring Cloud common :
          <p>Spring Cloud Commons delivers features as two libraries: </P>
            <ol>
              <li>Spring Cloud Context</li>
              <li>Spring Cloud Commons</li>
            </ol>
          <p>Spring Cloud Context provides utilities and special services for the ApplicationContext of a Spring Cloud application (bootstrap context, encryption, refresh scope and environment endpoints).(eg. Spring Cloud Netflix vs. Spring Cloud Consul)</p>
        </li>
      </ul>
    <li>lp-hta-cloud-config-service</li>
      <ul>
        <li>Spring Cloud config :
          <p>Spring Cloud Config provides server and client-side support for externalized configuration in a distributed system. With the Config Server you have a central place to manage external properties for applications across all environments. The concepts on both client and server map identically to the Spring Environment and PropertySource abstractions, so they fit very well with Spring applications, but can be used with any application running in any language</p>
        </li>
      </ul>
    <li>lp-hta-registry-service</li>
      <ul>
        <li>Spring Cloud Netflix (Service Discovery / Circuit Breaker) :
          <p>Spring Cloud Netflix provides Netflix OSS integrations for Spring Boot apps through autoconfiguration and binding to the Spring Environment and other Spring programming model idioms. The patterns provided include Service Discovery (Eureka), Circuit Breaker (Hystrix), Intelligent Routing (Zuul) and Client Side Load Balancing (Ribbon)..</p>
        </li>
      </ul>
</ul> 

<h3>Core Services&ensp;&ensp;:book: :book:</h3>

<ul>
  <li>lp-hta-vehicle-service</li>
    <ul>
      <li> spring: application: name: vehicleservice </li>
      <li> URL:  <a> http://vehicleservice/vehicle/* </a>  </li>
    </ul>
  <li>lp-hta-driver-service</li>
    <ul>
      <li> spring: application: name: driverservice </li>
      <li> URL:  <a> http://driverservice/driver/* </a>  </li>
    </ul>
  <li>lp-hta-trip-service</li>
    <ul>
      <li> spring: application: name: tripservice </li>
      <li> URL:  <a> http://tripservice/trip/* </a>  </li>
    </ul>
  <li>lp-hta-payment-service</li>
    <ul>
      <li> spring: application: name: paymentservice </li>
      <li> URL:  <a> http://paymentservice/payment/* </a>  </li>
    </ul>
  <li>lp-hta-notify-service</li>
    <ul>
      <li> spring: application: name: notifyservice </li>
      <li> URL:  <a> http://notifyservice/notify/* </a>  </li>
    </ul>
  <li>lp-hta-counter-service</li>
    <ul>
      <li> spring: application: name: counterservice </li>
      <li> URL:  <a> http://counterservice/counter/* </a>  </li>
    </ul>
  <li>lp-hta-billing-service</li>
    <ul>
      <li> spring: application: name: billingservice </li>
      <li> URL:  <a> http://billingservice/billing/* </a>  </li>
    </ul>
</ul> 


