package com.example.authentication.mcpserver.tools;


import org.springaicommunity.mcp.annotation.McpArg;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class McpTools {
    @McpTool(name = "getEmployee",
            description = "Get information about a given employee")
    public Employee getEmployee(@McpArg(description = "The employee name") String name) {
        return getAllEmployees().stream()
                .filter(e -> e.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
    @McpTool(description = "Get All Employees")
    public List<Employee> getAllEmployees() {
        return List.of(
                new Employee("Salma Bourizi", 13500, 7.0/12.0),
                new Employee("employee", 12300, 4.0),
                new Employee("Salma", 16000, 2.0)
        );
    }
}
record Employee(String name, double salary, double seniority){}
