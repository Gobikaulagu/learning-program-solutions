import React from "react";
import { shallow, mount } from "enzyme";
import CohortDetails from "./CohortDetails";
import { CohortsData } from "./Cohort";

describe("Cohort Details Component", () => {
  test("should create the component", () => {
    const wrapper = shallow(<CohortDetails cohort={CohortsData[0]} />);
    expect(wrapper.exists()).toBe(true);
  });

  test("should initialize the props", () => {
    const cohort = CohortsData[1];
    const wrapper = mount(<CohortDetails cohort={cohort} />);
    expect(wrapper.props().cohort).toEqual(cohort);
  });

  test("should display cohort code in h3", () => {
    const cohort = CohortsData[2];
    const wrapper = mount(<CohortDetails cohort={cohort} />);
    expect(wrapper.find("h3").text()).toContain(cohort.cohortCode);
  });

  test("should always render same html", () => {
    const wrapper = shallow(<CohortDetails cohort={CohortsData[3]} />);
    expect(wrapper).toMatchSnapshot();
  });
});
