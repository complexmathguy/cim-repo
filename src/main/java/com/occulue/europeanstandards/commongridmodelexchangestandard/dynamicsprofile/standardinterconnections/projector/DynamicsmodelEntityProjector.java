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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardinterconnections.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.projector.*;
import com.occulue.repository.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for Dynamicsmodel as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DynamicsmodelAggregate
 *
 * @author your_name_here
 */
@Component("dynamicsmodel-entity-projector")
public class DynamicsmodelEntityProjector {

  // core constructor
  public DynamicsmodelEntityProjector(DynamicsmodelRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Dynamicsmodel
   *
   * @param	entity Dynamicsmodel
   */
  public Dynamicsmodel create(Dynamicsmodel entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Dynamicsmodel
   *
   * @param	entity Dynamicsmodel
   */
  public Dynamicsmodel update(Dynamicsmodel entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Dynamicsmodel
   *
   * @param	id		UUID
   */
  public Dynamicsmodel delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Dynamicsmodel entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /**
   * Method to retrieve the Dynamicsmodel via an FindDynamicsmodelQuery
   *
   * @return query FindDynamicsmodelQuery
   */
  @SuppressWarnings("unused")
  public Dynamicsmodel find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Dynamicsmodel - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Dynamicsmodels
   *
   * @param query FindAllDynamicsmodelQuery
   * @return List<Dynamicsmodel>
   */
  @SuppressWarnings("unused")
  public List<Dynamicsmodel> findAll(FindAllDynamicsmodelQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Dynamicsmodel - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DynamicsmodelRepository repository;

  private static final Logger LOGGER =
      Logger.getLogger(DynamicsmodelEntityProjector.class.getName());
}
