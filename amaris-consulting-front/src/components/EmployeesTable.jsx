import React from 'react';

const EmployeesTable = ({ employees }) => (
    <div>
        {employees === undefined ? (
            <>
                {<h1>Error!</h1>}
            </>
        ) : (
            <table className="table table-bordered table-hover">
                <thead className="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Salary</th>
                        <th>Annual Salary</th>
                        <th>Profile Picture</th>
                    </tr>
                </thead>
                <tbody>
                    {employees.map((item) => (
                        <tr key={item.id}>
                            <td>{item.id}</td>
                            <td>{item.name}</td>
                            <td>{item.age}</td>
                            <td>{item.salary}</td>
                            <td>{item.annualSalary}</td>
                            <td>
                                <img
                                    src={item.profileImage}
                                    alt={`Profile of ${item.name}`}
                                    style={{ width: '50px', height: '50px' }}
                                />
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        )}
    </div>
);

export default EmployeesTable;