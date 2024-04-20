import React from "react";
import { PageHeader, Space, Table } from "antd";
import {ColumnsType, TablePaginationConfig} from "antd/lib/table/interface";
import { AxiosError } from "axios";
import {FacultyListProvider, useFacultyListContext} from "./context";
import Page from "../../components/Page";
import Notify from "../../components/Notify";
import StudentDTO from "../../dtos/StudentDTO";
import FacultyDTO from "../../dtos/FacultyDTO";

const FacultyList = () => {
    const { state, dispatch, getFacultyList } = useFacultyListContext();

    const columns: ColumnsType<FacultyDTO> = [
        {
            title: "Email",
            render: (record: FacultyDTO) => record.email,
        },
        {
            title: "Name",
            render: (record: FacultyDTO) => record.name,
        },
        {
            title: "Department",
            render: (record: FacultyDTO) => record.department,
        },
        {
            title: "Roll Number",
            render: (record: FacultyDTO) => record.rollno,
        },

    ];

    React.useEffect(() => {
        fetchData();
        // eslint-disable-next-line
    }, []);


    const fetchData = () => {
        console.log("coming to fetch the data");
        getFacultyList().catch((error: AxiosError) => {
            Notify({ type: "error", message: error.response?.data.message });
        });
    };


    return (
        <Page title="Faculty List">
            <PageHeader title="Faculty List" />
            <Space direction="vertical" size={16} style={{ width: "100%" }}>
                <Table
                    size="middle"
                    scroll={{ x: "100vh" }}
                    dataSource={state.facultyList}
                    columns={columns}
                    loading={state.loading}
                    rowKey={(record: FacultyDTO) => record.id!}
                />
            </Space>
        </Page>
    );
};

const FacultyListContainer = () => {
    return (
        <FacultyListProvider>
            <FacultyList />
        </FacultyListProvider>
    );
};
export default FacultyListContainer;
