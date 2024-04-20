import StudentDTO from "../../dtos/StudentDTO";
import StudentDetailsDTO from "../../dtos/StudentDetailsDTO";

export type StudentRankState = {
    studentList: StudentDTO[];
    studentDetails: StudentDetailsDTO;
    loading: boolean;
};

export const initialStudent: StudentDTO={
    id: 0,
    name: "",
    email: "",
    department: "",
    rollno:  "",
    stack: 0,
    marks: 0,
    project: 0,
}
export const initialStudentDetails: StudentDetailsDTO= {
    stageList : [],
    levelList : [],
    studentResponse : initialStudent,
}
export const initialStudentRankState: StudentRankState ={
    studentList : [],
    studentDetails: initialStudentDetails,
    loading:true,
}


export type StudentRankAction =
    | { type: "SET_STUDENT_RANK"; payload: StudentDTO[] }
    | { type: "SET_STUDENT_DETAILS"; payload: StudentDetailsDTO}
    | { type: "SET_LOADING"; payload: boolean };

export const studentRankReducer = (
    state: StudentRankState,
    action: StudentRankAction
) => {
    switch (action.type) {
        case "SET_STUDENT_RANK":
            return { ...state, studentList: action.payload };
        case "SET_STUDENT_DETAILS":
            return { ...state, studentDetails: action.payload };
        case "SET_LOADING":
            return { ...state, loading: action.payload };
        default:
            return state;
    }
};