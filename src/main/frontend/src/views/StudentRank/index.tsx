import React from "react";
import { PageHeader, Space, Table, Tooltip } from "antd";
import { ColumnsType, TablePaginationConfig } from "antd/lib/table/interface";
import { AxiosError } from "axios";
import {StudentRankProvider, useStudentRankContext} from "./context";
import Page from "../../components/Page";
import LiveScoreResponseDTO from "../../dtos/LiveScoreResponseDTO";
import Notify from "../../components/Notify";
import NewTabLink from "../../components/NewTabLink";
import StudentDTO from "../../dtos/StudentDTO";

const StudentRankList = () => {
    const { state, dispatch, getStudentRank } = useStudentRankContext();

    const columns: ColumnsType<StudentDTO> = [
        {
            title: "Score",
            render: (record: StudentDTO) => record.email,
        },
        {
            title: "Source",
            align: "center",
            width: 100,
            render: (row: StudentDTO) => (
                <Space size={10}>
                </Space>
            ),
        },
    ];

    React.useEffect(() => {
        fetchData();
        // eslint-disable-next-line
    }, []);


    const fetchData = () => {
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
