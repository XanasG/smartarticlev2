import React from "react";
import PropTypes from "prop-types";
import { Container, Row, Col } from "shards-react";

import PageTitle from "./../components/common/PageTitle";
import TopReferrals from "./../components/common/TopReferrals";

const Dashboard = () => (
  <Container fluid className="main-content-container px-4">
    {/* Page Header */}
    <Row noGutters className="page-header py-4">
      <PageTitle title="Dashboard" subtitle="Dashboard" className="text-sm-left mb-3" />
    </Row>

  </Container>
);

export default Dashboard;
