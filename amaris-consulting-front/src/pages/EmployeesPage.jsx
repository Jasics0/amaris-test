import { useState } from "react";
import Button from "../components/Button";
import EmployeesTable from "../components/EmployeesTable";
import TextField from "../components/TextField";
import { getEmployees, getEmployeeById } from "../services/EmployeesService";

export default function EmployeesPage() {
    const [data, setData] = useState([]);
    const [employeeId, setEmployeeId] = useState(undefined);

    const onClick = async () => {
        try {
            if (employeeId === undefined || employeeId === null || employeeId === "") {
                const employeesData = await getEmployees();
                console.log("Data despues del fetch: ", employeesData);
                setData(employeesData);
            } else {
                const employeesData = await getEmployeeById(employeeId);
                console.log("Data despues del fetch: ", employeesData);
                setData(employeesData);
            }

        } catch (error) {
            console.error("Error fetching data: ", error);
        }
    };

    const onChange = (event) => {
        const inputValue = event.target.value;
        setEmployeeId(inputValue);
    };

    return (
        <>
            <TextField onChange={onChange} />
            <Button onClickButton={onClick} />
            <EmployeesTable employees={data} />
        </>
    );
}