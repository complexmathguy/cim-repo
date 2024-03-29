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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector;

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
 * Projector for FloatProxy as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by FloatProxyAggregate
 *
 * @author your_name_here
 */
@Component("floatProxy-entity-projector")
public class FloatProxyEntityProjector {

  // core constructor
  public FloatProxyEntityProjector(FloatProxyRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a FloatProxy
   *
   * @param	entity FloatProxy
   */
  public FloatProxy create(FloatProxy entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a FloatProxy
   *
   * @param	entity FloatProxy
   */
  public FloatProxy update(FloatProxy entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a FloatProxy
   *
   * @param	id		UUID
   */
  public FloatProxy delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    FloatProxy entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /**
   * Method to retrieve the FloatProxy via an FindFloatProxyQuery
   *
   * @return query FindFloatProxyQuery
   */
  @SuppressWarnings("unused")
  public FloatProxy find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a FloatProxy - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all FloatProxys
   *
   * @param query FindAllFloatProxyQuery
   * @return List<FloatProxy>
   */
  @SuppressWarnings("unused")
  public List<FloatProxy> findAll(FindAllFloatProxyQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all FloatProxy - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final FloatProxyRepository repository;

  @Autowired
  @Qualifier(value = "activePowerPerFrequency-entity-projector")
  ActivePowerPerFrequencyEntityProjector ActivePowerPerFrequencyProjector;

  private static final Logger LOGGER = Logger.getLogger(FloatProxyEntityProjector.class.getName());
}
