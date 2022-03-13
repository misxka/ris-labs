package com.viaryha.ejb;

import com.viaryha.ejb.entities.Department;
import jakarta.ejb.Local;

import java.math.BigDecimal;

@Local
public interface DepartmentHandlerLocal {
    Department[] getTwoSmallestDepartments();
    BigDecimal dollarToYen(BigDecimal dollars);
    BigDecimal yenToEuro(BigDecimal yen);
}
