import React, {useState} from "react";
import {Button, Card, Col, Form, Input, Layout, PageHeader, Row, Space, Table} from "antd";
import {ColumnsType, TablePaginationConfig} from "antd/lib/table/interface";
import { AxiosError } from "axios";
import {FacultyListProvider, useFacultyListContext} from "./context";
import Page from "../../components/Page";
import Notify from "../../components/Notify";
import FacultyDTO from "../../dtos/FacultyDTO";

const FacultyList = () => {
    const { state, dispatch, getFacultyList, updateFacultyList } = useFacultyListContext();
    const [selectedFaculty, setSelectedFaculty] = useState<FacultyDTO>();
    const [form] = Form.useForm();

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

    const onFinish = (data: FacultyDTO) => {
        if (selectedFaculty) {
            // Assuming you have an `id` field in your StudentDTO
            data.id = selectedFaculty.id;
            updateFacultyList(data).catch((error: AxiosError) => {
                Notify({ type: "error", message: error.response?.data.message });
            }).finally(fetchData);
        }
    };

    const onTableRowClick = (record: FacultyDTO) => {
        setSelectedFaculty(record);
        form.resetFields();
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
                    onRow={(record) => ({
                        onClick: () => onTableRowClick(record),
                    })}
                />
            </Space>
            <Layout style={{ minHeight: "100vh" }}>
                <Layout.Content>
                    <Page title="Faculty Update Form">
                        <Row align="middle" style={{ minHeight: "100vh" }}>
                            <Col
                                xs={{ span: 24 }}
                                sm={{ span: 12, offset: 6 }}
                                lg={{ span: 10, offset: 7 }}
                                xl={{ span: 8, offset: 8 }}
                                xxl={{ span: 6, offset: 9 }}
                            >
                                <Card bordered className="auth-card">
                                    <span style={{ textAlign: "center", paddingBottom: "20px" }}>
                                        <h1>Update Faculty</h1>
                                    </span>
                                    <Form
                                        form={form}
                                        layout="vertical"
                                        onFinish={onFinish}
                                        autoComplete="off"
                                        initialValues={selectedFaculty ? { ...selectedFaculty } : {}}
                                    >
                                        <Form.Item
                                            name="email"
                                            label="Email"
                                            rules={[{ required: true, message: "Email is required" }]}
                                        >
                                            <Input allowClear placeholder="Email" />
                                        </Form.Item>
                                        <Form.Item
                                            name="department"
                                            label="Department"
                                            rules={[{ required: true, message: "Department is required" }]}
                                        >
                                            <Input allowClear placeholder="Department" />
                                        </Form.Item>
                                        <Form.Item
                                            name="rollno"
                                            label="Roll Number"
                                            rules={[{ required: true, message: "Roll Number is required" }]}
                                        >
                                            <Input allowClear placeholder="Roll Number" />
                                        </Form.Item>
                                        <Row gutter={[24, 0]}>
                                            <Col span={12}>
                                                <Form.Item label=" ">
                                                    <Button htmlType="reset" block>
                                                        Reset
                                                    </Button>
                                                </Form.Item>
                                            </Col>
                                            <Col span={12}>
                                                <Form.Item label=" ">
                                                    <Button block type="primary" htmlType="submit">
                                                        Update Faculty
                                                    </Button>
                                                </Form.Item>
                                            </Col>
                                        </Row>
                                    </Form>
                                </Card>
                            </Col>
                        </Row>
                    </Page>
                </Layout.Content>
            </Layout>
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
