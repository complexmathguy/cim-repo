/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.projector.*;
import com.occulue.repository.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for OverexcitationLimiterDynamics as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by OverexcitationLimiterDynamicsAggregate
 *
 * @author your_name_here
 */
@Component("overexcitationLimiterDynamics-entity-projector")
public class OverexcitationLimiterDynamicsEntityProjector {

  // core constructor
  public OverexcitationLimiterDynamicsEntityProjector(
      OverexcitationLimiterDynamicsRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a OverexcitationLimiterDynamics
   *
   * @param	entity OverexcitationLimiterDynamics
   */
  public OverexcitationLimiterDynamics create(OverexcitationLimiterDynamics entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a OverexcitationLimiterDynamics
   *
   * @param	entity OverexcitationLimiterDynamics
   */
  public OverexcitationLimiterDynamics update(OverexcitationLimiterDynamics entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a OverexcitationLimiterDynamics
   *
   * @param	id		UUID
   */
  public OverexcitationLimiterDynamics delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    OverexcitationLimiterDynamics entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a OverexcitationLimiterDynamics
   *
   * @param	parentId	UUID
   * @param	assignment 	OverexcitationLimiterDynamics
   * @return	OverexcitationLimiterDynamics
   */
  public OverexcitationLimiterDynamics assignOverexcitationLimiterDynamics(
      UUID parentId, OverexcitationLimiterDynamics assignment) {
    LOGGER.info("assigning OverexcitationLimiterDynamics as " + assignment.toString());

    OverexcitationLimiterDynamics parentEntity = repository.findById(parentId).get();
    assignment =
        OverexcitationLimiterDynamicsProjector.find(
            assignment.getOverexcitationLimiterDynamicsId());

    // ------------------------------------------
    // assign the OverexcitationLimiterDynamics to the parent entity
    // ------------------------------------------
    parentEntity.setOverexcitationLimiterDynamics(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the OverexcitationLimiterDynamics
   *
   * @param	parentId		UUID
   * @return	OverexcitationLimiterDynamics
   */
  public OverexcitationLimiterDynamics unAssignOverexcitationLimiterDynamics(UUID parentId) {
    OverexcitationLimiterDynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning OverexcitationLimiterDynamics on " + parentEntity.toString());

    // ------------------------------------------
    // null out the OverexcitationLimiterDynamics on the parent entithy
    // ------------------------------------------
    parentEntity.setOverexcitationLimiterDynamics(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the OverexcitationLimiterDynamics via an
   * FindOverexcitationLimiterDynamicsQuery
   *
   * @return query FindOverexcitationLimiterDynamicsQuery
   */
  @SuppressWarnings("unused")
  public OverexcitationLimiterDynamics find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a OverexcitationLimiterDynamics - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all OverexcitationLimiterDynamicss
   *
   * @param query FindAllOverexcitationLimiterDynamicsQuery
   * @return List<OverexcitationLimiterDynamics>
   */
  @SuppressWarnings("unused")
  public List<OverexcitationLimiterDynamics> findAll(
      FindAllOverexcitationLimiterDynamicsQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING,
          "Failed to find all OverexcitationLimiterDynamics - {0}",
          exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final OverexcitationLimiterDynamicsRepository repository;

  @Autowired
  @Qualifier(value = "overexcitationLimiterDynamics-entity-projector")
  OverexcitationLimiterDynamicsEntityProjector OverexcitationLimiterDynamicsProjector;

  private static final Logger LOGGER =
      Logger.getLogger(OverexcitationLimiterDynamicsEntityProjector.class.getName());
}
