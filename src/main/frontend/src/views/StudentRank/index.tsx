import React from "react";
import { PageHeader, Space, Table } from "antd";
import {ColumnsType, TablePaginationConfig} from "antd/lib/table/interface";
import { AxiosError } from "axios";
import {StudentRankProvider, useStudentRankContext} from "./context";
import Page from "../../components/Page";
import Notify from "../../components/Notify";
import StudentDTO from "../../dtos/StudentDTO";

const StudentRankList = () => {
    const { state, dispatch, getStudentRank } = useStudentRankContext();

    const columns: ColumnsType<StudentDTO> = [
        {
            title: "Email",
            render: (record: StudentDTO) => record.email,
        },
        {
            title: "Name",
            render: (record: StudentDTO) => record.name,
        },
        {
            title: "Department",
            render: (record: StudentDTO) => record.department,
        },
        {
            title: "Roll Number",
            render: (record: StudentDTO) => record.rollno,
        },
        {
            title: "Marks",
            render: (record: StudentDTO) => record.marks,
        },
        {
            title: "Stack",
            render: (record: StudentDTO) => record.stack,
        },
        {
            title: "Project",
            render: (record: StudentDTO) => record.project,
        },

    ];

    React.useEffect(() => {
        fetchData();
        // eslint-disable-next-line
    }, []);


    const fetchData = () => {
        console.log("coming to fetch the data");
        getStudentRank().catch((error: AxiosError) => {
            Notify({ type: "error", message: error.response?.data.message });
        });
    };


    return (
        <Page title="Student Rank">
            <PageHeader title="Student Rank" />
            <Space direction="vertical" size={16} style={{ width: "100%" }}>
                <Table
                    size="middle"
                    scroll={{ x: "100vh" }}
                    dataSource={state.studentList}
                    columns={columns}
                    loading={state.loading}
                    rowKey={(record: StudentDTO) => record.id!}
                />
            </Space>
        </Page>
    );
};

const StudentRankContainer = () => {
    return (
        <StudentRankProvider>
            <StudentRankList />
        </StudentRankProvider>
    );
};
export default StudentRankContainer;
