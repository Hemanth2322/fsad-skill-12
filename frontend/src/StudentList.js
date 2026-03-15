import React,{useState,useEffect} from "react";
import axios from "axios";

function StudentList(){

    const [students,setStudents]=useState([]);

    useEffect(()=>{
        axios.get("http://localhost:8080/students")
            .then(res=>{
                setStudents(res.data);
            });
    },[]);

    return(
        <div>
            <h2>Student List</h2>

            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Course</th>
                </tr>

                {students.map(s=>(
                    <tr key={s.id}>
                        <td>{s.id}</td>
                        <td>{s.name}</td>
                        <td>{s.email}</td>
                        <td>{s.course}</td>
                    </tr>
                ))}

            </table>

        </div>
    );

}

export default StudentList;
